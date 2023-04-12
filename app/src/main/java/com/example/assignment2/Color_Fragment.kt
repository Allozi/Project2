import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.core.view.iterator
import com.example.assignment2.R

class Color_Fragment : Fragment() {

    private val colors = arrayOf(
        "Red",
        "Green",
        "Blue",
        "Yellow",
        "Magenta",
        "Cyan"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_color_, container, false)

        // Set up the spinner
        val spinner = view.findViewById<Spinner>(R.id.color_spinner)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Set up the background color button
        val backgroundButton = view.findViewById<Button>(R.id.background_button)
        backgroundButton.setOnClickListener {
            val color = spinner.selectedItem.toString()
            val backgroundColor = getBackgroundColor(color)
            view.setBackgroundColor(backgroundColor)

            // Iterate over all buttons and set their background color
            for (child in view as ViewGroup) {
                if (child is Button) {
                    child.setBackgroundColor(getButtonColor(color))
                }
            }
        }

        // Set up the button color button
        val buttonColorButton = view.findViewById<Button>(R.id.button_color_button)
        buttonColorButton.setOnClickListener {
            val color = spinner.selectedItem.toString()
            val buttonColor = getButtonColor(color)

            // Set the background color of the button color button
            buttonColorButton.setBackgroundColor(buttonColor)

            // Iterate over all buttons and set their background color
            for (child in view as ViewGroup) {
                if (child is Button) {
                    child.setBackgroundColor(buttonColor)
                }
            }
        }

        return view
    }

    private fun getBackgroundColor(colorName: String): Int {
        return when (colorName) {
            "Red" -> Color.RED
            "Green" -> Color.GREEN
            "Blue" -> Color.BLUE
            "Yellow" -> Color.YELLOW
            "Magenta" -> Color.MAGENTA
            "Cyan" -> Color.CYAN
            else -> Color.WHITE
        }
    }

    private fun getButtonColor(colorName: String): Int {
        return when (colorName) {
            "Red" -> Color.parseColor("#FF8A80")
            "Green" -> Color.parseColor("#B9F6CA")
            "Blue" -> Color.parseColor("#80D8FF")
            "Yellow" -> Color.parseColor("#FFFF8D")
            "Magenta" -> Color.parseColor("#EA80FC")
            "Cyan" -> Color.parseColor("#84FFFF")
            else -> Color.parseColor("#E0E0E0")
        }
    }

}
