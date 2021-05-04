package com.globant.roomapplication.ui.fragments.typerelations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.globant.roomapplication.R
import com.globant.roomapplication.databinding.FragmentTypeRelationsBinding
import com.globant.roomapplication.ui.model.ViewState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TypeRelationsFragment : Fragment() {

    private val viewModel: TypeRelationsViewModel by viewModels()

    private var _binding: FragmentTypeRelationsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTypeRelationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.configure()
        viewModel.schoolAndDirector.observe(viewLifecycleOwner) {
            Timber.i("onViewCreated: ${it}")
            when (it) {
                is ViewState.Loading -> "Cargando ..."
                is ViewState.Success -> "${it.data}"
                is ViewState.Error -> "${it.error}"
            }
        }

        viewModel.schoolWithStudents.observe(viewLifecycleOwner) {
            Timber.i("onViewCreated: ${it}")
            when (it) {
                is ViewState.Loading -> "Cargando ..."
                is ViewState.Success -> "${it.data}"
                is ViewState.Error -> "${it.error}"
            }
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}