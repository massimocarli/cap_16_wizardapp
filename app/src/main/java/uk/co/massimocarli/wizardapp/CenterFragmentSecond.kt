package uk.co.massimocarli.wizardapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.center_fragment_second.view.*


/**
 * Second step in the navigation flow
 */
class CenterFragmentSecond : Fragment() {

  val args: CenterFragmentSecondArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(
      R.layout.center_fragment_second,
      container,
      false
    )
    view.outputText.text = args.firstText
    view.nextStepButton.setOnClickListener {
      val input2 = view.inputText.text.toString()
      val action = CenterFragmentSecondDirections.centerActionToStep3(
        args.firstText,
        input2
      )
      view.findNavController().navigate(action)
    }
    return view
  }
}
