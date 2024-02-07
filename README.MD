# FastCampusPay 프로젝트 소개

이 프로젝트는 패스트캠퍼스에서 진행한 강의를 기반으로 한 간편결제 프로젝트로, 온라인으로 MSA (마이크로서비스 아키텍처)를 중점적으로 다루고 있습니다.

강의 링크: [실전 MSA 초격차 패키지 Online](https://fastcampus.co.kr/dev_online_projectmsa)

원본 깃허브 링크: [FastCampus-Pay 프로젝트 개요](https://github.com/KimByeongKou/fastcampus-pay#fastcampus-pay-project-overview)

## 프로젝트 개요

이 레포지토리는 단일 개발자가 강의를 통해 학습하고, 학습한 내용을 실습을 통해 확장하며 공부하는 용도로 만들어진 프로젝트입니다.

간편 결제 프로젝트는 패스트캠퍼스에서 제공하는 
온라인 MSA 강의를 기반으로 하며, 
프로젝트는 여러 도메인을 포괄하는 간편 결제를 주제로 합니다. 

이 프로젝트는 회원가입, 뱅킹, 머니, 송금, 결제, 정산이라는 
총 6개의 독립적인 서비스로 구성되어 있으며, 
각 서비스는 기본 기능을 Hexagonal Architecture로 구현하고 
일부 기능에는 EDA, CQRS, Event Sourcing, Saga Pattern 등을 
적용하여 진행됩니다. 

또한, Spring Boot 및 Java 11을 기반으로 프로젝트를 구성하며, 
EDA 구현을 위해 Axon Framework v4.6.0을 사용하고 있습니다. 
해당 프로젝트는 개발자 개인의 학습 및 연습을 목적으로 제작되었으며, 
실제 간편 결제 도메인 시스템과는 복잡성 측면에서 차이가 있습니다.

(Chpater 3 실습1에 말씀하신것 처럼 public repo를 만들고 진행)

### 사용된 기술 스택

- Spring Boot, Java 21, Spring Data JPA, H2, MySQL, Lombok, Gradle, JWT, Axon Framework, Docker, Docker Compose, AWS DynamoDB
