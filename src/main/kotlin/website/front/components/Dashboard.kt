package website.front.components

import kotlinx.html.*
import website.syntax_extensions.addContent
import website.syntax_extensions.classes

fun FlowContent.dashboard() = div(classes = classes("relative h-screen overflow-hidden")) {
    attributes["x-data"] = "{ sidebarOpen: false }"

    HeaderNotLoggedIn()
    MenuMovingSidebar()
    MenuStaticSidebar()

    main(classes("mx-auto overflow-hidden h-full w-full relative flex flex-col")) {
        attributes["x-bind:class"] = "{ 'pl-56': sidebarOpen, 'pl-20': !sidebarOpen }"

        span(classes = classes("top-0 w-full h-16 flex items-center  space-x-4 justify-start sticky z-10 ")) {
            val tagList = listOf("Everything", "Music", "Action", "New Recommendations")
            TagItem(tagList)
        }

        div(classes = classes("overflow-y-auto h-full pt-10 pr-8 scrollbar-hide")) {
            div(classes = classes("grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-y-8 gap-x-6 ")) {
                for (i in 0..15) {
                    div(classes = classes("flex flex-col transition-all duration-300")) {
                        div(classes = classes("relative w-full pt-[56.25%]")) {
                            // Video preview placeholder
                            div(classes = classes("absolute inset-0 bg-gray-200 rounded-lg overflow-hidden")) {
                                // You can replace this with an actual video preview or thumbnail
                                img(classes = classes("w-full h-full flex items-center justify-center ")) {
                                    src = "https://picsum.photos/id/${i}/200/300"
                                    alt = "Video preview"
                                }
                            }
                        }
                        div(classes = classes("mt-2 flex")) {
                            div(classes = classes("flex-shrink-0 mr-3")) {
                                // Channel avatar placeholder
                                div(classes = classes("w-9 h-9 rounded-full bg-gray-300")) {}
                            }
                            div(classes = classes("flex-grow")) {
                                h3(classes = classes("text-base my-video-title mb-1 line-clamp-2")) { +"Video Title ${i + 1} - This is a longer title to demonstrate wrapping" }
                                p(classes = classes("text-sm my-video-details")) { addContent("Channel Name") }
                                p(classes = classes("text-sm my-video-details")) { addContent("123K views • 2 days ago") }
                            }
                        }
                    }
                }
            }
        }

        div(classes = classes("h-32"))
    }
}







