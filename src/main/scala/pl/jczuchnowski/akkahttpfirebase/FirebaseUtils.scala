package pl.jczuchnowski.akkahttpfirebase

import com.google.firebase.auth.{ FirebaseAuth, FirebaseToken }
import com.google.api.core.{ ApiFuture, ApiFutures, ApiFutureCallback }
import scala.concurrent.{ Future, Promise }
import scala.concurrent.ExecutionContext.Implicits.global

trait FirebaseUtils {

  def verifyToken(idToken: String): Future[Option[FirebaseToken]] = {
    val p = Promise[Option[FirebaseToken]]()

    val apiFuture: ApiFuture[FirebaseToken] = FirebaseAuth.getInstance().verifyIdTokenAsync(idToken)
    
    val callback = new ApiFutureCallback[FirebaseToken]() {
      override def onSuccess(decodedToken: FirebaseToken): Unit = {
        p success Some(decodedToken)
      }

      override def onFailure(e: Throwable): Unit = {
        p success None
      }
    }
    
    ApiFutures.addCallback(apiFuture, callback)

    p.future    
  }

}

object FirebaseUtils extends FirebaseUtils
