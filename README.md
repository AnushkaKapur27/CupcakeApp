# 🧁 Cupcake App

A delightful multi-screen cupcake ordering app built with **Jetpack Compose**, showcasing advanced state management, navigation, and order sharing features.

---

## ✨ Overview

The **Cupcake App** walks users through a smooth, step-by-step cupcake ordering experience. From choosing the number of cupcakes to selecting flavors and pickup dates, the app demonstrates how to manage user input and navigate across multiple screens — all while maintaining a clean architecture using modern Android development tools.

---

## 🚀 Features

- 🧭 **Multi-Screen Navigation** — Built with `NavController` and `NavHost` for a seamless Compose navigation flow.
- 🧁 **Custom Order Flow** — Users can choose cupcake quantity, flavor, and pickup date.
- 🔄 **State Management** — Order details persist across screens using shared `ViewModel`.
- 📤 **Order Sharing** — Users can share their order summary with other apps via Android’s **implicit intents** (e.g., email, messages).
- 🎨 **Material Design 3** — Stylish UI built entirely with Compose and Material design components.

---

## 🛠 Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Navigation Component (Compose)**
- **State Hoisting**
- **ViewModel + LiveData/State**
- **Android Implicit Intents**

---

## 📸 Screenshots

### Start Screen And Quantity select

![WhatsApp Image 2025-06-20 at 14 30 17_1a0b77b8](https://github.com/user-attachments/assets/bf8e5b5e-b7a0-4014-9e78-f1b50f7de71d)

### Flavor Select

![WhatsApp Image 2025-06-20 at 14 30 17_28253a7a](https://github.com/user-attachments/assets/1a40c4d7-8f03-4811-9db1-f06901648cb4)

### Date Select

![WhatsApp Image 2025-06-20 at 14 30 18_d298f5e0](https://github.com/user-attachments/assets/4fd7e494-f895-4b1e-849d-85305ccedb4b)

### Order Summary

![WhatsApp Image 2025-06-20 at 14 30 18_9d496358](https://github.com/user-attachments/assets/b4a40884-2484-421a-bc1f-7209d2e926bb)

---

## 💡 App Flow

```mermaid
graph TD
    Start[Start Order] --> Quantity[Select Quantity]
    Quantity --> Flavor[Select Flavor]
    Flavor --> Date[Select Pickup Date]
    Date --> Summary[Order Summary]
    Summary --> Share[Share or Cancel]
