package controllers

import play.api.mvc._
import play.api.data.Forms
import play.api.data.Form
import models.MatchingInput

object Application extends Controller {

  val matchingForm = Form(
    Forms.mapping(
      "pattern" -> Forms.nonEmptyText,
      "text" -> Forms.nonEmptyText
    )(MatchingInput.apply)(MatchingInput.unapply))

  def index = Action {
    Ok(views.html.index())
  }

  def doMatch = Action {
    implicit request => matchingForm.bindFromRequest.fold(
      _ => BadRequest(views.html.index()),
      matchingInput => Redirect(routes.Application.index))
  }
}
