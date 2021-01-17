package co.paulfran.memorygame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val frag = inflater.inflate(R.layout.fragment_game, container, false)

        return frag
    }

    companion object {
        fun newInstance(): GameFragment {
            return GameFragment()
        }
    }

    internal inner class GameRecyclerAdapter(val inputData: ArrayList<TextView>) : RecyclerView.Adapter<GameRecyclerAdapter.RecyclerViewHolder>() {
        internal inner class RecyclerViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.card_layout, parent, false)) {
            val tileParent = itemView.findViewById<SquareFrameLayout>(R.id.tileParent)

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val vh = RecyclerViewHolder(inflater, parent)
            return vh
        }

        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            val thisTile = inputData[position]
            holder.tileParent.addView(thisTile)
        }

        override fun getItemCount(): Int = inputData.size
    }

}

