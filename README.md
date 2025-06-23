# KotlinFullStack

## Table of Contents

* [🇬🇧 English](#english)
* [🇵🇱 Polski](#polski)

---

<a name="english"></a>
## 🇬🇧 English

Backend and Frontend written fully in Kotlin.

My **tech stack** is:

* **Tailwind CSS** for styling my components
* **HTMX** for network calls
* **Alpine JS** for component reactivity
* **Ktor** for backend
* **Kotlin HTML DSL** for generating HTML
* **Google Cloud** for video and image storage

The core idea is to **not write anything beside the Kotlin code** needed for HTML generation. I embed **Tailwind classes, Alpine and HTMX attributes** directly inside the Kotlin code to make reusable, styled, and reactive components, and then send them as HTML.

---

### ✅ Required to run

* **Docker**
* **NPM**
* **TailwindCSS** (if you want to generate the CSS file yourself; otherwise, use the `build` directory)
* **Gradle**
* **Java**

---

### ▶️ How to run

```bash
npm install                     # Install dependencies
docker compose -f docker-compose.yml up -d    # Start the database
npm run build:css               # OPTIONAL: Only if you want to regenerate CSS
chmod +x ./gradlew              # Only if you're on Linux
./gradlew run                   # Run the program
````

-----

-----

<a name="polski"\>\</a\>

## 🇵🇱 Polski

Backend i Frontend napisane w całości w Kotlinie.

Mój **stos technologiczny** to:

  * **Tailwind CSS** do stylowania komponentów
  * **HTMX** do wywołań sieciowych
  * **Alpine JS** do reaktywności komponentów
  * **Ktor** dla backendu
  * **Kotlin HTML DSL** do generowania HTML
  * **Google Cloud** do przechowywania wideo i obrazów

Główna idea to **nie pisać nic poza kodem Kotlina** potrzebnym do generowania HTML. Osadzam **klasy Tailwind, atrybuty Alpine i HTMX** bezpośrednio w kodzie Kotlina, aby tworzyć komponenty wielokrotnego użytku, ostylowane i reaktywne, które następnie są wysyłane jako HTML.

-----

### ✅ Wymagane do uruchomienia

  * **Docker**
  * **NPM**
  * **TailwindCSS** (jeśli chcesz samodzielnie wygenerować plik CSS; w przeciwnym razie możesz użyć katalogu `build`)
  * **Gradle**
  * **Java**

-----

### ▶️ Jak uruchomić

```bash
npm install                     # Zainstaluj zależności
docker compose -f docker-compose.yml up -d    # Uruchom bazę danych
npm run build:css               # OPCJONALNIE: Tylko jeśli chcesz ponownie wygenerować CSS
chmod +x ./gradlew              # Tylko jeśli używasz systemu Linux
./gradlew run                   # Uruchom program
```

