package uk.co.massimocarli.wizardapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.center_fragment_start.*
import kotlinx.android.synthetic.main.center_fragment_start.view.*

/**
 * This is the class for the Fragment we use for collecting the first
 * text to send to the second fragment
 */
class CenterFragmentStart : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val view = inflater.inflate(
      R.layout.center_fragment_start,
      container,
      false
    )
    view.nextStepButton.setOnClickListener {
      val input1 = inputText.text.toString()
      val action = CenterFragmentStartDirections.centerActionToStep2(input1)
      view.findNavController().navigate(action)
    }
    return view
  }
}
