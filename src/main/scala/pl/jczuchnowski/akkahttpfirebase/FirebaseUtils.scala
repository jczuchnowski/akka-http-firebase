package pl.jczuchnowski.akkahttpfirebase

import com.google.firebase.auth.{ FirebaseAuth, FirebaseToken }
import com.google.firebase.tasks.{ OnFailureListener, OnSuccessListener }
import scala.concurrent.{ Future, Promise }
import scala.concurrent.ExecutionContext.Implicits.global

trait FirebaseUtils {

  def verifyToken(idToken: String): Future[Option[FirebaseToken]] = {
    val p = Promise[Option[FirebaseToken]]()

    FirebaseAuth.getInstance().verifyIdToken(idToken)
      .addOnSuccessListener(new OnSuccessListener[FirebaseToken]() {
        override def onSuccess(decodedToken: FirebaseToken): Unit = {
          p success Some(decodedToken)
        }
      })
      .addOnFailureListener(new OnFailureListener() {
        override def onFailure(e: Exception): Unit = {
          p success None
        }
      })

    p.future    
  }

}

object FirebaseUtils extends FirebaseUtils
