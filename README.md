# RuoYi WMS 백엔드 — 한국어 Fork

RuoYi 기반 창고 관리 시스템을 분석하고 한국어 화면·서버 메시지와 재고 수량 검증을 개선한 Fork입니다.

- [포트폴리오 분석·개선 기록](docs/portfolio/README.ko.md)
- [입출고 수량 검증과 테스트](docs/portfolio/quantity-validation.ko.md)
- [한국어 화면과 서버 메시지](docs/portfolio/localization.ko.md)
- [로컬 실행 방법](docs/portfolio/run.ko.md)

원본 프로젝트의 출처와 라이선스를 유지합니다. 아래 배지는 원본 README에 포함된 이미지입니다.

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://gitee.com/zccbbg/ruoyi-fast-service/blob/master/LICENSE)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1-blue.svg)]()
[![JDK-17](https://img.shields.io/badge/JDK-17-green.svg)]()

## 프로젝트 소개

이 프로젝트는 `ruoyi-vue-fast`를 기반으로 구현된 WMS입니다. 입출고 전표, 창고, 품목, 거래처, 재고 현황 및 변경 이력을 관리하며 LODOP 및 웹 인쇄를 지원합니다.

원본 개발팀은 코드와 문서를 오픈소스로 제공하며, 라이선스 조건을 준수하는 범위에서 개인·기업의 사용 및 상업적 활용을 허용한다고 안내합니다. 구체적인 조건은 저장소의 [LICENSE](LICENSE)를 확인하세요.

현재 한국어 브랜치의 주요 구성은 다음과 같습니다.

- 프런트엔드: Vue 3, Element Plus, Vite
- 백엔드: Java 17, Spring Boot 3.2.6, MyBatis Plus, Sa-Token, Redis
- 기능: 동적 권한 메뉴, 권한 제어, 코드 생성

원본 개발팀은 관심과 학습을 위해 프로젝트를 공개하고 기술을 함께 배울 수 있도록 하는 것을 지향합니다.

## 연결할 프런트엔드

- [한국어 프런트엔드 Fork](https://github.com/ShaunKR/RuoYi-WMS-VUE/tree/portfolio/korean-ui)
- [원본 프런트엔드 — GitHub](https://github.com/zccbbg/RuoYi-WMS-VUE)
- [원본 프런트엔드 — Gitee](https://gitee.com/zccbbg/ruo-yi-wms-vue)

한국어 버전을 실행하려면 두 저장소 모두 `portfolio/korean-ui` 브랜치를 사용하세요.

## 원본 RuoYi 실습 기술 자료

원본 개발팀은 문서 하단의 위챗 공식 계정을 구독한 뒤 `星球`를 보내 관련 기술 자료를 안내받도록 설명합니다. 이 단어는 원본 계정에서 사용하는 요청 키워드입니다.

## 원본 온라인 데모

[원본 WMS 데모](https://wms.ichengle.top/)

## 원본 브랜치 안내

| 브랜치 | 구성 및 특징 |
|---|---|
| `lite` | Java 17·Vue 3 기반. 다중 창고를 지원하며 창고 구역 개념을 제외한 간단한 재고 관리 구성입니다. |
| `advance` | Java 17·Vue 3 기반. 다중 창고·창고 구역, 생산일·유효기간·시리얼번호를 지원하며 개별 식별 코드 관리에 활용할 수 있습니다. |
| `v1` | Java 8·Vue 2 기반의 이전 버전입니다. |
| `master` | 원본의 `lite` 브랜치와 동기화됩니다. |

위 표는 원본 저장소의 브랜치 설명이며, 이 Fork에는 모든 원본 브랜치가 포함된 것은 아닙니다. 기능은 선택한 브랜치에 따라 달라질 수 있습니다.

## 주요 WMS 기능

1. **홈:** 재고 부족·유효기간 경고와 기초 통계를 표시합니다.
2. **창고·창고 구역:** 창고 관련 기초 정보를 관리합니다.
3. **품목:** 상품과 규격 등의 기초 정보를 관리합니다.
4. **고객·공급업체:** 거래처와 담당자 정보를 관리합니다.
5. **입고:** 전표를 임시 저장·무효 처리·입고 완료 상태로 관리합니다. 원본 설명에는 구매·외주·반품 입고가 포함되며 웹 인쇄를 지원합니다.
6. **출고:** 전표를 임시 저장·무효 처리·출고 완료 상태로 관리합니다. 원본 설명에는 판매·외주·이관 출고가 포함되며 웹 인쇄를 지원합니다.
7. **재고 이동:** 이동 전표를 임시 저장·무효 처리·이동 완료 상태로 관리합니다.
8. **재고 실사:** 실사 전표를 임시 저장·무효 처리·실사 완료 상태로 관리합니다.
9. **재고 현황:** 창고·창고 구역·상품별 재고 수량을 확인합니다.
10. **재고 이력:** 품목별 재고 변경 내역을 조회합니다.
11. **재고 상세:** 창고·창고 구역 및 상품별 보관 상세를 조회합니다.

## 변경 이력

원본 변경 이력은 [UpdateHistory.md](docs/UpdateHistory.md)를 참고하세요.

## 원본 프로젝트에 이슈와 PR 제출하기

- 이슈 제출 전: [원본 이슈 작성 안내](docs/ISSUE_TEMPLATE.zh-CN.md)
- PR 제출 전: [원본 PR 작성 안내](docs/PULL_REQUEST_TEMPLATE.zh-CN.md)

위 문서는 원본 참고 자료이며 중국어로 작성되어 있습니다.

## 로컬 실행 및 배포

한국어 Fork의 실행 구성과 명령은 [로컬 실행 문서](docs/portfolio/run.ko.md)에 정리했습니다. MySQL·Redis는 WMS 전용 Docker Compose 구성으로 실행합니다.

원본 개발팀의 안내도 참고할 수 있습니다.

- [원본 로컬 실행 안내](https://docs.ichengle.top/wms/open/run2.html)
- [원본 배포 안내](https://docs.ichengle.top/wms/open/ops2.html)

## 원본 화면 예시

이미지는 원본 그대로 유지합니다. 현재 한국어 화면과 문구가 다를 수 있습니다.

![首页](docs/首页.png)
![大屏](docs/大屏.png)
![入库单](docs/入库单.jpg)
![编辑入库单](docs/编辑入库单.jpg)
![打印](docs/打印.jpg)
![库存盘点](docs/库存盘点.jpg)
![库存统计](docs/库存统计.jpg)
![库存明细](docs/库存明细.jpg)
![库存记录](docs/库存记录.jpg)

## 원본 프로젝트에 기여하기

원본 프로젝트는 `dev` 개발 브랜치로 PR을 제출하여 통합 테스트와 배포를 진행하도록 안내하고 있습니다.

## 원본 개발팀 소개

원본 개발팀은 2017년에 설립되었으며 프런트엔드와 백엔드 아키텍처를 개발합니다. 기업용 공통 UI와 사용자 경험을 개선하고, 지속적으로 오픈소스 프로젝트를 제공하는 것을 목표로 합니다.

이 소개는 원본 개발팀에 관한 내용입니다. 이 Fork에서 수행한 작업은 위 포트폴리오 문서에 별도로 정리했습니다.

## 원본 개발팀 커뮤니티·기술 지원

| 위챗 공식 계정 |
|:---:|
| <img src="docs/gzh.jpg" width="200px"> |

원본 개발팀의 안내에 따르면 QR 코드를 스캔해 공식 계정을 구독한 뒤, 커뮤니티 참여는 `加群`, 기술 지원은 `支持`를 보내 문의할 수 있습니다. 이 단어들은 원본 계정에서 사용하는 요청 키워드입니다.
