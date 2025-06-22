# 🧑‍⚖️ Mobile Jury App

![linia](https://www.gify.net/data/media/562/linia-ruchomy-obrazek-0184.gif)

Aplikacja mobilna stworzona w **Jetpack Compose** z wykorzystaniem **Kotlin**, przeznaczona do oceniania uczestników konkursów przez jurorów. Dane są pobierane i wysyłane z/do backendu opartego na **PHP i MySQL**.

## 🎯 Główne funkcje

- ✅ Logowanie jurorów
- 📥 Pobieranie uczestników, kategorii i kryteriów z API
- 📝 Wystawianie ocen i zapisywanie ich do bazy danych
- 🔄 Synchronizacja danych z serwerem
- 👁️ Przejrzysty interfejs z Jetpack Compose

## 🧱 Technologie

- Kotlin
- Jetpack Compose
- MVVM + ViewModel
- Retrofit (komunikacja z API)
- Moshi / Gson
- PHP + MySQL (backend)

## ⚙️ Jak uruchomić

1. Skonfiguruj backend (np. na XAMPP lub serwerze online)
2. W pliku `RetrofitClient.kt` ustaw odpowiedni adres IP / URL do API
3. Uruchom aplikację w Android Studio
4. Upewnij się że posiadasz dobrze zbudowaną baze **SQl**
5. Sklonuj repozytorium:
   ```bash
   https://github.com/Kubusiowy/MobileJuryApp
