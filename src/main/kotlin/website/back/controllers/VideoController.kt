package website.back.controllers

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import kotlinx.html.body
import kotlinx.html.id
import kotlinx.html.script
import website.back.db.getRandom20Videos
import website.back.db.getRandom20VideosExcept
import website.back.db.getVideoById
import website.back.db.getVideoByTitle
import website.back.plugins.UserSession
import website.front.ANSI_GREEN
import website.front.ANSI_RESET
import website.front.components.VideoGrid
import website.front.components.video.VideoNotFound
import website.front.components.video.VideoView
import website.front.links.imports
import website.syntax_extensions.addContent
import website.syntax_extensions.classes

fun Routing.VideoController() {

    get("/video-grid") {
        val title = call.request.queryParameters["title"]
        val userSession = call.sessions.get<UserSession>()
        println("${ANSI_GREEN} $title ${ANSI_RESET}")

        if (title == null) {
            call.respondHtml(status = HttpStatusCode.NoContent) {
                imports()
                body() {
                    addContent("No videos found")
                }
            }
        } else if (title.isBlank() || title.isEmpty()) {
            val videos = getRandom20Videos()
            println("${ANSI_GREEN}Searched blank${ANSI_RESET}")
            println(videos.toString())
            call.respondHtml(status = HttpStatusCode.OK) {
                imports()
                body() {
                    VideoGrid(videos)
                }
            }
        } else {
            val foundVideos = getVideoByTitle(title)
            println("${ANSI_GREEN}Found Videos with title $title ${ANSI_RESET}")
            println(foundVideos.toString())
            call.respondHtml(status = HttpStatusCode.OK) {
                imports()
                body {
                    VideoGrid(foundVideos)
                }
            }
        }
    }

    get("/video/{id}") {
        val videoID = call.parameters["id"]?.toIntOrNull()
        val userSession = call.sessions.get<UserSession>()

        if (videoID == null) {
            call.respondHtml(status = HttpStatusCode.NoContent) {
                imports()

                body(classes = classes("overflow-hidden")) {
                    id = "home"
                    VideoNotFound()
                    script { src = "/static/global_scripts.js" }
                }
            }
        } else {
            val videos = getRandom20VideosExcept(videoID)

            call.respondHtml(status = HttpStatusCode.OK) {
                val currentVideo = getVideoById(videoID)
                imports()
                body(classes = classes("overflow-hidden h-full")) {
                    id = "home"
                    VideoView(videos, userSession, currentVideo)
                    script { src = "/static/global_scripts.js" }
                }
            }
        }

    }
}