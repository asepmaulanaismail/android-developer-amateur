package com.asepmaulanaismail.dicoding.androidamateur.myrecycleview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View

class MainActivity : AppCompatActivity() {
    private var list = ArrayList<TwiceMember>()
    private var mode: Int? = 0
    companion object {
        val STATE_TITLE = "state_string"
        val STATE_LIST = "state_list"
        val STATE_MODE = "state_mode"
        val MEMBER = "member"
        val BUNDLE = "bundle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_category.setHasFixedSize(true)

        if (savedInstanceState == null){
            setActionBarTitle("List")
            list = TwiceMemberData.listData
            showRecyclerList()
            mode = R.id.action_list
        }else{
            val stateTitle:String? = savedInstanceState.getString(STATE_TITLE)
            val stateList: ArrayList<TwiceMember>? = savedInstanceState.getParcelableArrayList(STATE_LIST)
            val stateMode = savedInstanceState.getInt(STATE_MODE)
            setActionBarTitle(stateTitle)
            list = stateList!!
            setMode(stateMode)
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(STATE_TITLE, supportActionBar?.title.toString())
        outState?.putParcelableArrayList(STATE_LIST, list)
        outState?.putInt(STATE_MODE, mode!!)
    }

    private fun showSelectedTwiceMember(twiceMember: TwiceMember) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable(MEMBER, twiceMember)
        intent.putExtra(BUNDLE, bundle)
        startActivity(intent)
    }

    private fun showRecyclerList() {
        rv_category.layoutManager = LinearLayoutManager(this)
        val listTwiceMemberAdapter = ListTwiceMemberAdapter(this)
        listTwiceMemberAdapter.setListTwiceMember(list)
        rv_category.adapter = listTwiceMemberAdapter
        ItemClickSupport.addTo(rv_category).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                showSelectedTwiceMember(list[position])
            }
        })
    }

    private fun showRecyclerGrid() {
        rv_category.layoutManager = GridLayoutManager(this, 2)
        val gridTwiceMember = GridTwiceMemberAdapter(this)
        gridTwiceMember.setListTwiceMember(list)
        rv_category.adapter = gridTwiceMember
        ItemClickSupport.addTo(rv_category).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                showSelectedTwiceMember(list[position])
            }
        })
    }

    private fun showRecyclerCardView() {
        rv_category.layoutManager = LinearLayoutManager(this)
        val cardViewTwiceMemberAdapter = CardViewTwiceMemberAdapter(this)
        cardViewTwiceMemberAdapter.setListTwiceMember(list)
        rv_category.adapter = cardViewTwiceMemberAdapter
        ItemClickSupport.addTo(rv_category).setOnItemClickListener(object : ItemClickSupport.OnItemClickListener {
            override fun onItemClicked(recyclerView: RecyclerView, position: Int, v: View) {
                showSelectedTwiceMember(list[position])
            }
        })
    }

    private fun setActionBarTitle(title: String?){
        supportActionBar?.title = "Twice Member: $title"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        setMode(item!!.itemId)
        return super.onOptionsItemSelected(item)
    }

    fun setMode(selectedMode: Int){
        when(selectedMode){
            R.id.action_list -> {
                setActionBarTitle("List")
                showRecyclerList()
            }
            R.id.action_grid -> {
                setActionBarTitle("Grid")
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                setActionBarTitle("CardView")
                showRecyclerCardView()
            }
        }
        mode = selectedMode
    }
}
