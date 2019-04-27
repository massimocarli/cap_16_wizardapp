package uk.co.massimocarli.wizardapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.center_fragment_third.view.*

/**
 * Last step for the navigation
 */
class CenterFragmentThird : Fragment() {

  val args: CenterFragmentThirdArgs by navArgs()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(
      R.layout.center_fragment_third,
      container,
      false
    )
    view.firstOutput.text = args.firstText
    view.secondOutput.text = args.secondText
    return view
  }
}
