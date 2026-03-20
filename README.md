[![build status](https://github.com/opengoofy/hippo4j/actions/workflows/ci.yml/badge.svg?event=push)](https://github.com/opengoofy/hippo4j)
[![codecov](https://codecov.io/gh/opengoofy/hippo4j/branch/develop/graph/badge.svg?token=WBUVJN107I)](https://codecov.io/gh/opengoofy/hippo4j)
![maven](https://img.shields.io/maven-central/v/com.alibaba.otter/canal.svg)
[![license](https://img.shields.io/badge/license-Apache--2.0-green.svg)](http://www.apache.org/licenses/LICENSE-2.0)
![](https://img.shields.io/github/contributors/opengoofy/hippo4j)
[![percentage of issues still open](http://isitmaintained.com/badge/open/opengoofy/hippo4j.svg)](http://isitmaintained.com/project/opengoofy/hippo4j "percentage of issues still open")

![GitHub last commit (branch)](https://img.shields.io/github/last-commit/opengoofy/hippo4j/develop?color=orange)

## Introduction

![](https://oss.open8gu.com/image-20231115133642504.png)

Short Link refers to converting a long original URL (Uniform Resource Locator) into a shorter, easier-to-remember URL using a specific algorithm or service. A short link usually contains only a few characters, while the original URL can be much longer.

The principle is simple: generate a relatively short link from the original URL, then redirect visitors from the short link to the original URL.

> 📢 New Project
>
> [Ragent AI](https://nageoffer.com/ragent) - An enterprise-grade Agentic RAG project and the first open-source work from the Nageoffer community in the AI space. Architecture and implementation follow the same high standard, making it suitable for campus or professional resumes.

In more detail:

1. **Generate a unique identifier**: When a user submits a long URL, the service generates a unique identifier or short code.
2. **Associate the identifier with the URL**: The short-link service stores the mapping between the identifier and the original URL in a database or other persistent storage.
3. **Create the short link**: Prefix the identifier with the service domain, for example `http://nurl.ink`, to form a short link.
4. **Redirect**: When a user visits the short link, the service looks up the original URL by identifier and redirects the user there.
5. **Track usage**: Many short-link services also provide analytics such as visit counts, sources, and geolocation.

Short links appear frequently in daily life, especially in marketing messages and event promotions. They help businesses monitor user behavior and click-through rates during marketing campaigns.

![](https://oss.open8gu.com/IMG_9858-20231126.jpg)

The main benefits include:

- **Improve user experience**: Short links are easier to remember and share.
- **Save space**: They are shorter than long URLs, which is useful in character-limited contexts.
- **Improve presentation**: Short links look cleaner and more readable.
- **Enable analytics**: They make it possible to track visits and user behavior.

## Official Docs

- What is the SaaS short-link system: [https://nageoffer.com/shortlink](https://nageoffer.com/shortlink)
- 🔥SaaS short-link video tutorial: [https://nageoffer.com/shortlink/video](https://nageoffer.com/shortlink/video)

---

Online demo: [SaaS Short Link Demo](http://shortlink.nageoffer.com)

Due to network safety rules, redirect targets are limited to links under the domains [Nageoffer](https://nageoffer.com), [Zhihu](https://zhihu.com), [Juejin](https://juejin.cn), and [Cnblogs](https://cnblogs.com).

---

## Architecture

The system uses JDK 17 and a Spring Boot 3 / Spring Cloud microservice architecture to provide a reliable short-link service under high concurrency and large data volumes.

Studying the project helps explain how the system works while exposing readers to modern technology choices and patterns.

![](https://oss.open8gu.com/image-20231026132606180.png)

## Community

Open source is not easy. Star the project if it helps you.

If you want updates and project articles, follow the WeChat public account: `马丁玩编程`.

If you have questions or suggestions, add the author and note `link` to receive project materials and discuss with the community.

![](https://oss.open8gu.com/martin-tryoffer.png)

## Project Quality

This project is built in a SaaS style. SaaS means "Software as a Service", where users access the application over the internet instead of installing and maintaining software locally.

Because this is a SaaS system, it introduces several engineering challenges. Those challenges are also the project highlights:

1. **High concurrency**: The system may face large volumes of concurrent traffic, especially during peak periods.
2. **Large-scale storage**: It may need to store substantial amounts of user data across databases and caches.
3. **Multi-tenant scenarios**: Multiple tenants share one system, so isolation, security, and performance matter.
4. **Data security**: User data privacy and unauthorized access prevention are critical.
5. **Scalability**: The system should scale with user growth and business expansion.

The implementation addresses these concerns and delivers a highly available, scalable SaaS short-link system. It also includes a polished admin console for portfolio or graduation project use.

It is designed to be a strong project for interviews.

## How to Learn

I personally prefer learning through documentation. When building the 12306 railway ticketing system, I wrote extensive source, design, and from-scratch documentation.

Some people prefer learning with videos alongside documentation. This project was built with that in mind.

The video course is roughly 80 lessons and 20-30 hours long.

> The code was written while recording the tutorial from scratch.

Short-link video learning resource: [SaaS Short Link Hands-on Video Course](https://nageoffer.com/shortlink/video/)

![](https://oss.open8gu.com/image-20231122173916783.png)
