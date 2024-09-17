# vue3-spring-forum
vue3 with SpringBoot Toy Project

# 설명

# Front End 
  vite 빌드 기반 vue3 와 TypeScript 연습을 위해 생성되었습니다 
  
# Back End 
  
모놀리식 헥사고날 기반으로 작성되고 있습니다.
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


# BASE 출처
https://github.com/dlask913/vue3-spring-project

