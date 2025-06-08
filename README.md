# KotlinFullStack
Backend and Frontend written fully in Kotlin. My tech stack is :
- Tailwind CSS for styling my components,
- HTMX for network calls,
- Alphine JS for component reactivity,
- Ktor for backend,
- Kotlin HTML DSL  for generating HTML,
- Google Cloud for video and image storage.
  
The idea is to not write anything beside the Kotlin code needed for HTML generation. I embed Tailwind classes , Alpine and HTMX attributes inside the Kotlin code to make reusable, styled and reactive components and then send them as HTML.  

# Required to run: 
  - Docker
  - NPM
  - TailwindCSS (if u want to generate the CSS file yourself, otherwise use the build directory) 
  - Gradle
  - Java

# How to run:
  - npm install (to install dependecies)d
  - docker compose -f docker-compose.yml up -d (Starts the database)
  - npm run build:css (OPTIONAL unless you want to remake the build directory)
  - chmod +x ./gradlew (if you're on linux )
  - ./gradlew run (to start the program)



