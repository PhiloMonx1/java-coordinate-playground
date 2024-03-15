## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

---
## 미션 진행

---
1. Git convention & Branch strategy
> 브랜치 전략은 GitHub Flow 전략으로 삼았다.
>
> ![GitHub Flow](https://velog.velcdn.com/images/gmlstjq123/post/04588f97-e776-4829-a519-58f7c93b6c4a/image.png)
>
> 1. 'master' 브랜치 대신 'main' 브랜치를 사용한다.
> 2. 미션 진행 방법을 따르기 위해 'dev' 브랜치를 사용한다.

> 커밋 메시지 컨벤션은 아래 내용을 따른다.
> 1. Feat : 새로운 기능을 추가하는 경우
> 2. Fix : 버그를 고친경우
> 3. Docs : 문서를 수정한 경우
> 4. Style : 코드 포맷 변경, 세미콜론 누락, 코드 수정이 없는경우
> 5. Refactor : 코드 리펙토링
> 6. Test : 테스트 코드. 리펙토링 테스트 코드를 추가했을 때
> 7. Chore : 빌드 업무 수정, 패키지 매니저 수정
> 8. Add : 서비스 코드의 추가가 있는 경우
> 9. Comment : 주석의 추가/변경이 있는 경우
>
> 출처 : https://velog.io/@msung99/Git-Commit-Message-Convension
---