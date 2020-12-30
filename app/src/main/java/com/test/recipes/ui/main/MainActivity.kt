package com.test.recipes.ui.main

import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.recipes.R
import com.test.recipes.data.objects.Recipe
import com.test.recipes.ui.details.DetailActivity
import android.os.Bundle as Bundle

class MainActivity: AppCompatActivity(), IMainView {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
        initViews()
    }

    private fun initViews() {
        findViewById<ProgressBar>(R.id.ProgressBar).visibility = View.VISIBLE
    }

    private fun initPresenter() {
        presenter = MainPresenter(this)
    }

    override val it: String?
        get() = TODO("Not yet implemented")

    override fun showList(list: List<Recipe>) {
        val recyclerView = findViewById<RecyclerView>(R.id.MainRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //TODO Adapter
        recyclerView.adapter = CustomAdapter(list, onClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        })
    }


    override fun showLoader(flag: Boolean) {
        if (flag) {
            findViewById<ProgressBar>(R.id.ProgressBar).visibility = View.VISIBLE
            findViewById<RecyclerView>(R.id.MainRecycler).visibility = View.GONE
        } else {
            findViewById<ProgressBar>(R.id.ProgressBar).visibility = View.GONE
            findViewById<RecyclerView>(R.id.MainRecycler).visibility = View.VISIBLE
        }

    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

