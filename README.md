# vue3-spring-forum
vue3 with SpringBoot Toy Project

# 설명

# Front End 
  vite 빌드 기반 vue3 와 TypeScript 연습을 위해 생성되었습니다 
  
# Back End 
  1차 2차 프로젝트로 나뉠 예정입니다.
  
  1차로 모놀리식 헥사고날 기반으로 작성되고 있습니다.
  아래와 같이 각자의 관심사 별로 패키지가 분리되어 작성될 예정입니다.
```md  
app
  ├── member
│   ├── adapter
│   │   ├── in
│   │   │   ├── security
│   │   │   └── web
│   │   └── out
│   │       ├── persistence
│   │       └── security
│   ├── application
│   │   ├── port
│   │   │   ├── in
│   │   │   └── out
│   │   └── service
│   └── domain
└── notice
    ├── adapter
    │   ├── in
    │   │   └── web
    │   └── out
    │       └── persistence
    ├── application
    │   ├── in
    │   ├── out
    │   └── service
    └── domain
```
2차로는 1차의 모놀리식 프로젝트를 MSA로 변경을 목표로 하고 있습니다.


# BASE 출처
https://github.com/dlask913/vue3-spring-project

