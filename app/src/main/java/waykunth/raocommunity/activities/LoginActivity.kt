package waykunth.raocommunity.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import kotlinx.android.synthetic.main.activity_login.*
import waykunth.raocommunity.R
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.google.android.gms.tasks.Task
import android.widget.TextView
import android.support.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import android.support.annotation.Nullable


class LoginActivity : AppCompatActivity() {

    private lateinit var googleSignInClient : GoogleSignInClient
    private val RC_SIGN_IN = 9001



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail().requestProfile()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this,gso)


        googlesign_in_button.setOnClickListener {
             signIn()
        }

            val animSlide = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.slide)
            login_image.animation = animSlide

    }


    public override fun onStart() {
        super.onStart()

        // [START on_start_sign_in]
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)
        // [END on_start_sign_in]
    }


    // [START onActivityResult]
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }
    // [END onActivityResult]


    // [START handleSignInResult]
    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            updateUI(null)
        }

    }
    // [END handleSignInResult]


    // [START signIn]
    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    // [END signIn]


    // [START signOut]
    private fun signOut() {
        googleSignInClient.signOut()
            .addOnCompleteListener(this) {
                // [START_EXCLUDE]
                updateUI(null)
                // [END_EXCLUDE]
            }
    }
    // [END signOut]


    // [START revokeAccess]
    private fun revokeAccess() {
        googleSignInClient.revokeAccess()
            .addOnCompleteListener(this) {
                // [START_EXCLUDE]
                updateUI(null)
                // [END_EXCLUDE]
            }
    }
    // [END revokeAccess]


    private fun updateUI(@Nullable account: GoogleSignInAccount?) {
        if (account != null) {
            val nextActivity = Intent(this,MainActivity::class.java)
            startActivity(nextActivity)
            Toast.makeText(this,"${account.displayName}\t${account.email}\t${account.photoUrl}",Toast.LENGTH_LONG).show()
        }
    }


}
