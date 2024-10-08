﻿[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

<h3>Contact US</h3>

<p> A simple API for the operation of any form on any homepage.<br/>
  <a href="https://github.com/IsFantasy/contact-us"><strong>Explore the docs »</strong></a><br/><br/>
  <a href="https://github.com/IsFantasy/contact-us/issues/new">Report Bug</a> ·
  <a href="https://github.com/IsFantasy/contact-us/issues/new">Request Feature</a>
</p>

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul><li><a href="#built-with">Built With</a></li></ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

## About The Project

[![contact-us Screen Shot][product-screenshot]](src/main/resources/img/app.png)

There are many great API templates, but I created this one to be simple, effective, and easy to integrate. It’s designed for the "Contact Us" section of any simple page, using a multi-layer architecture for better structure and maintainability.

Here's why:
* Focus on your project: This API handles contact forms so you can focus on other parts of your project.
* Save time: Don’t build everything from scratch—integrate this and move on.
* Solid architecture: With N-layer architecture, it’s easier to maintain and scale.

### Built With

The technologies used for this project are all in the Java environment.
[![Spring][Spring]][Spring-url]

## Getting Started

### Prerequisites

Have an email account, if it is Gmail, have 2-step authentication activated and the password for applications.

### Installation

_The installation does not depend on any external service except for the mail._

1. Clone the repo
   ```sh
   git clone https://github.com/IsFantasy/contact-us.git
   ```
2. Install dependencies
   ```sh
   mvn clean install
   ```
3. Enter in `application.properties`
   ```js
   spring.mail.username=$EMAIL
   spring.mail.password=$APP_PASSWORD
   ```
4. Run the app
   ```sh
   mvn spring-boot:run
   ```
   
## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact
IsFantasy - [@paiqui.dev](https://www.instagram.com/paiqui.dev) - antoniopaiva2608@gmail.com 

Project Link: [https://github.com/IsFantasy/contact-us](https://github.com/IsFantasy/contact-us)

## Acknowledgments

These resources were helpful to me in the project.

* [Choose an Open Source License](https://choosealicense.com)
* [Img Shields](https://shields.io)

[contributors-shield]: https://img.shields.io/github/contributors/IsFantasy/contact-us?style=for-the-badge
[contributors-url]: https://github.com/IsFantasy/contact-us/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/IsFantasy/contact-us?style=for-the-badge
[forks-url]: https://github.com/IsFantasy/contact-us/network/members
[stars-shield]: https://img.shields.io/github/stars/IsFantasy/contact-us?style=for-the-badge
[stars-url]: https://github.com/IsFantasy/contact-us/stargazers
[issues-shield]: https://img.shields.io/github/issues/IsFantasy/contact-us?style=for-the-badge
[issues-url]: https://github.com/IsFantasy/contact-us/issues
[license-shield]: https://img.shields.io/github/license/IsFantasy/contact-us?style=for-the-badge
[license-url]: https://github.com/IsFantasy/contact-us/blob/master/LICENSE
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/gabrielpaiva2608
[product-screenshot]: src/main/resources/img/app.png
[Java]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/es/
[Spring]: https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=Spring&logoColor=white
[Spring-url]: https://spring.io/
