package website.front.components.shared

import kotlinx.html.*
import website.back.plugins.UserSession
import website.front.ANSI_RED
import website.front.ANSI_RESET
import website.syntax_extensions.addContent
import website.syntax_extensions.classes

fun FlowContent.ProfilePill(userSession: UserSession, disabled: Boolean = false) {
    div(
        classes = classes(
            " w-10 h-10 button text-2xl",
            "flex",
            "items-center",
            "justify-center",
            "font-medium",
            "rounded-full",
            if (disabled) "" else "absolute top-3 right-8 cursor-pointer"
        )
    ) {
        id = "profileButton"
        if (!disabled) {
            attributes["x-on:click"] = "isOpen = !isOpen; console.log(isOpen)"
        }
        style = "background-color: ${userSession.color}"
        addContent(userSession.getInitial().toString())
    }
}

fun FlowContent.ChannelPill(color: String, initial: String, disabled: Boolean = false) {
    println(
        " $ANSI_RED ChannelPill(color=$color, initial=$initial, disabled=$disabled) $ANSI_RESET"
    )
    div(
        classes = classes(
            " w-10 h-10 button text-2xl",
            "flex",
            "items-center",
            "justify-center",
            "font-medium",
            "rounded-full",
        )
    ) {
        id = "channelButton"
        style = "background-color: $color"
        addContent(initial)
    }
}

fun FlowContent.ClickableChannelPill(color: String, initial: String, disabled: Boolean = false, email: String) {
    println(
        " $ANSI_RED ChannelPill(color=$color, initial=$initial, disabled=$disabled) $ANSI_RESET"
    )
    a(href = "/channel?email=$email", classes = "cursor-pointer") {

        // Add any HTMX attributes if you're using HTMX for navigation
        attributes["hx-boost"] = "true"

        div(
            classes = classes(
                "w-10 h-10 button text-2xl",
                "flex",
                "items-center",
                "justify-center",
                "font-medium",
                "rounded-full",
                if (!disabled) "hover:opacity-80 transition-opacity" else ""
            )
        ) {
            id = "channelButton"
            style = "background-color: $color"
            addContent(initial)
        }
    }}