package waykunth.raocommunity.activities

import android.content.Intent
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import waykunth.raocommunity.R
import waykunth.raocommunity.fragments.ExploreFragment
import waykunth.raocommunity.fragments.HomeFragment
import waykunth.raocommunity.fragments.MessagesFragment
import waykunth.raocommunity.fragments.NotificationsFragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.NavigationView
import android.view.MenuItem
import kotlinx.android.synthetic.main.appbar_main.*
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.activity_login.*


class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    private val manager : FragmentManager = supportFragmentManager
    private lateinit var drawerBtn : ImageView
    private var drawerLayout : DrawerLayout? = null
    private var id : String = ""
    private lateinit var  toolbar : Toolbar
    private lateinit var nextActivity : Intent
    private lateinit var editProfile : TextView

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                addHomeFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_explore -> {
                addExploreFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                addNotificationsFragment()
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_messages -> {
                addMessagesFragment()
                return@OnNavigationItemSelectedListener true
            }


        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addHomeFragment()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        drawerLayout = findViewById(R.id.drawer_layout)
        drawerBtn =  findViewById(R.id.drawer_btn)
        drawerBtn.setOnClickListener {
            drawerLayout!!.openDrawer(Gravity.START)
        }

        toolbar = findViewById(R.id.toolbar_main)
        toolbar.inflateMenu(R.menu.menu_appbar_main)
        toolbar.setOnMenuItemClickListener{

            when(it.itemId)
            {
                R.id.add_post -> goToActivity(CreatePostActivity::class.java)
                R.id.add_notification -> goToActivity(CreateNotificationActivity::class.java)
            }
            true
        }

        nav_view.setNavigationItemSelectedListener(this)

        val header = nav_view.getHeaderView(0)
        editProfile = header.findViewById(R.id.edit_profile) as TextView
        editProfile.setOnClickListener{
            goToActivity(EditProfileActivity::class.java)
            drawer_layout.closeDrawer(GravityCompat.START)
        }

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.my_posts -> {
                goToActivity(MyPostActivity::class.java)
            }

            R.id.my_notifications -> {
                goToActivity(MyNotificationActivity::class.java)
            }

            R.id.saved -> {
                goToActivity(SavedActivity::class.java)

            }

            R.id.faq -> {
            }


            R.id.logout -> {
                signOut()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }



    private fun goToActivity(destination : Class<*>)
    {
        nextActivity = Intent(this,destination)
        startActivity(nextActivity)
    }


    private fun addHomeFragment()
    {
         id = "home"
         val transaction = manager.beginTransaction()
         val fragment = HomeFragment()
         transaction.replace(R.id.container,fragment)
         transaction.addToBackStack(null)
         transaction.commit()

    }

    private fun addExploreFragment()
    {
        id = "explore"
        val transaction = manager.beginTransaction()
        val fragment = ExploreFragment()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    private fun addMessagesFragment()
    {
        id = "messages"
        val transaction = manager.beginTransaction()
        val fragment = MessagesFragment()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

   private fun addNotificationsFragment()
    {
        id = "notifications"
        val transaction = manager.beginTransaction()
        val fragment = NotificationsFragment()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



    override fun onBackPressed() {
        if(drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            drawerLayout!!.closeDrawer(Gravity.START)
            when(id)
            {
                "home" -> addHomeFragment()
                "explore" -> addExploreFragment()
                "messages" -> addMessagesFragment()
                "notifications" -> addMessagesFragment()
            }
        }
        else {
            finish()
        }
        super.onBackPressed()
    }


    private fun signOut() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail().requestProfile()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this,gso)
          googleSignInClient.signOut()
            .addOnCompleteListener(this) {
                 val out = Intent(this,LoginActivity::class.java)
                 startActivity(out)
            }
    }


}
