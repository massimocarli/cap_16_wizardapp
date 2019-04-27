package uk.co.massimocarli.wizardapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.left_fragment_start.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class LeftFragmentStart : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(
      R.layout.left_fragment_start,
      container,
      false
    )
    view.nextStepButton.setOnClickListener {
      view.findNavController().navigate(R.id.action_to_step2)
    }
    return view
  }
}
