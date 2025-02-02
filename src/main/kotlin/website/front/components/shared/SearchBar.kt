package website.front.components.shared

import kotlinx.html.*
import website.syntax_extensions.addContent
import website.syntax_extensions.classes


fun FlowContent.SearchBar() {
    span(classes = classes("absolute mx-auto top-2 left-1/2 transform -translate-x-1/2 h-12 rounded-full my-onBackground transition-all duration-300 ease-in-out")) {
        style = "width:33%"
        id = "search-bar"

        form(classes = classes("relative flex items-center w-full h-full")) {
            attributes["hx-get"] = "/video-grid"
            attributes["hx-target"] = "#videoGrid"
            attributes["hx-swap"] = "innerHTML"
            attributes["hx-trigger"] = "submit"

            input(
                classes = classes("w-11/12 pl-4 h-full pr-2 rounded-l-full rounded-r-0 my-search transition-all duration-300 ease-in-out focus:outline-none focus:border-blue-200"),
                type = InputType.search,
                name = "title"
            ) {
                placeholder = "Search"
            }

            button(classes = "absolute w-1/12 right-0 h-full px-4 rounded-r-full my-searchButton my-onBackground flex justify-center items-center") {
                i(classes = "material-symbols-outlined") {
                    addContent("search")
                }
            }
        }
    }
}