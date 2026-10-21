# 한국어 화면과 서버 메시지

프런트엔드와 백엔드의 `portfolio/korean-ui` 브랜치를 함께 사용한다.

## 변경

- `messages_ko_KR.properties`: 한국어 인증·입력 검증·권한·업로드 메시지 추가
- WMS 서비스: 재고 부족, 잘못된 수량, 중복 전표, 삭제 불가 메시지 한국어 적용
- WMS DTO와 내보내기: 필드명 및 검증 안내 한국어 적용
- 프런트엔드: 메뉴·상태·유형의 표시명만 번역하고 상태 코드와 사용자 입력 데이터는 유지

로그인 및 공통 국제화 메시지는 `Content-Language: ko_KR` 헤더로 요청한다.
WMS에 하드코딩되어 있던 서비스 메시지는 이 한국어 Fork에서 한국어로 변경했다.
언어 선택기를 제공하는 완전한 다국어 구현은 아니다.

## 확인

- 한국어 헤더를 포함한 빈 로그인 요청에 `아이디를 입력해 주세요.` 반환
- 재고 수량 단위 테스트 및 실제 MySQL 입출고·롤백 통합 테스트 재실행
- 원본 SQL 및 기존 학습 DB 데이터는 번역으로 덮어쓰지 않음

프런트엔드 상세: https://github.com/ShaunKR/RuoYi-WMS-VUE/blob/portfolio/korean-ui/docs/localization.ko.md
