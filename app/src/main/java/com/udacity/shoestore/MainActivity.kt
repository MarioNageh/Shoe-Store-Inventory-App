package com.udacity.shoestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.udacity.shoestore.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var appBarConfiguration: AppBarConfiguration? = null
    private var drawerLayout: DrawerLayout? = null
    private var toolbar: Toolbar? = null
    private var navController: NavController? = null
    private lateinit var navView: NavigationView
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        // Bind Views
        bindUi()
        setupActionBarWithNavigationDrawer()


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController!!, appBarConfiguration!!)
    }

    private fun setupActionBarWithNavigationDrawer() {


        // install Nav Controller
        navController = (supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
            .navController
        // Install App Bar
        setSupportActionBar(toolbar)

        NavigationUI.setupWithNavController(navView, navController!!)
        appBarConfiguration = AppBarConfiguration(
            navController!!.graph, drawerLayout
        )
        NavigationUI.setupActionBarWithNavController(this, navController!!, appBarConfiguration!!)


        navController!!.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> {
                    lockNavigationDrawer()
                    hideAppBar()
                }
                R.id.loginFragment -> {
                    hideAppBar()
                    lockNavigationDrawer()
                }
                R.id.welcomeFragment -> {
                    lockNavigationDrawer()
                    hideAppBar()
                }
                R.id.instructionFragment -> {
                    lockNavigationDrawer()
                    hideAppBar()
                }
                R.id.shoeFragment -> {
                    showAppBar()
                    unlockNavigationDrawer()
                }
            }

        }
//        navController.navigateUp()
        navView.setNavigationItemSelectedListener { menuItem ->
            val id = menuItem.itemId
            //it's possible to do more actions on several items, if there is a large amount of items I prefer switch(){case} instead of if()
            if (id == R.id.logout_menu_item) {
                logoutUser()
            }

            NavigationUI.setupActionBarWithNavController(
                this,
                navController!!,
                appBarConfiguration!!
            )


            //This is for maintaining the behavior of the Navigation view
            NavigationUI.onNavDestinationSelected(menuItem, navController!!)
            //This is for closing the drawer after acting on it
            drawerLayout?.closeDrawer(GravityCompat.START)
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout_menu_item -> {
                logoutUser()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun logoutUser() {
        val navOptions = NavOptions.Builder().setExitAnim(R.anim.slide_out_left)
            .setPopExitAnim(R.anim.slide_out_left).setPopUpTo(
                R.id.nav_graph, true
            ).setLaunchSingleTop(true).build()
        navController?.navigate(R.id.loginFragment, null, navOptions, null)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.nav_drawer_menu, menu)
        return true
    }

    private fun bindUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        toolbar = binding.appBarMan.toolbarView
        navView = binding.navView
    }

    private fun lockNavigationDrawer() {
        drawerLayout!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    private fun unlockNavigationDrawer() {
        drawerLayout!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    private fun hideAppBar() {
        supportActionBar?.hide()
    }

    private fun showAppBar() {
        supportActionBar?.show()
    }

    public fun getViewModel(): MainActivityViewModel {
        return mainActivityViewModel
    }
}
