import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.assignment2.R

class Calc_Fragment : Fragment() {

    private lateinit var num1Text: TextView
    private lateinit var num2Text: TextView
    private lateinit var resultText: TextView
    private lateinit var operatorSpinner: Spinner

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calc_, container, false)

        // Get references to the views
        num1Text = view.findViewById(R.id.num1_text)
        num2Text = view.findViewById(R.id.num2_text)
        resultText = view.findViewById(R.id.result_text)
        operatorSpinner = view.findViewById(R.id.operator_spinner)

        // Set up the operator spinner
        val operators = arrayOf("+", "-", "*", "/")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, operators)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        operatorSpinner.adapter = adapter

        // Set up the calculate button
        val calculateButton = view.findViewById<Button>(R.id.calculate_button)
        calculateButton.setOnClickListener {
            calculate()
        }

        return view
    }

    private fun calculate() {
        // Get the numbers from the text boxes
        val num1 = num1Text.text.toString().toDouble()
        val num2 = num2Text.text.toString().toDouble()

        // Get the selected operator
        val operators = arrayOf("+", "-", "*", "/")
        val selectedOperator = operators[operatorSpinner.selectedItemPosition]

        // Perform the calculation
        val result = when (selectedOperator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> throw IllegalArgumentException("Invalid operator")
        }

        // Display the result
        resultText.text = result.toString()
    }
}
