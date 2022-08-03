package edu.nextstep.camp.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import edu.nextstep.camp.calculator.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    private val viewModel: CalculatorViewModel by viewModels { ViewModelFactory(this) }
    private val recordsAdapter: RecordsAdapter by lazy { RecordsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewBinding()
        initRecords()
        initObserver()
    }

    private fun initRecords() {
        binding.recyclerView.adapter = recordsAdapter
    }

    private fun initViewBinding() {
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)
    }

    private fun initObserver() {
        viewModel.calculationFailed.observe(this) {
            showCalculationFailedToast()
        }
        viewModel.records.observe(this) {
            recordsAdapter.submitList(it)
        }
    }

    private fun showCalculationFailedToast() {
        Toast
            .makeText(this, R.string.incomplete_expression, Toast.LENGTH_SHORT)
            .show()
    }
}
