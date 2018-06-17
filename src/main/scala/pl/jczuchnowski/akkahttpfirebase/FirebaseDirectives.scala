package pl.jczuchnowski.akkahttpfirebase

import akka.http.scaladsl.server.directives.{ AuthenticationDirective, Credentials }
import akka.http.scaladsl.server.directives.Credentials.Provided
import akka.http.scaladsl.server.Directives._
import com.google.firebase.auth.FirebaseToken
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait FirebaseDirectives {
  
  def firebaseAuthenticator(credentials: Credentials): Future[Option[FirebaseToken]] =
    credentials match {
      case Provided(token) => FirebaseUtils.verifyToken(token)
      case _ => Future.successful(None)
    }

  def authenticateFirebase(realm: String): AuthenticationDirective[FirebaseToken] =
    authenticateOAuth2Async(realm, firebaseAuthenticator _)

}

object FirebaseDirectives extends FirebaseDirectives
