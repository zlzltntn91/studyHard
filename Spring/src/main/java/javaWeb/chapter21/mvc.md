# MVC
- 모델 2 아키텍쳐
- 다른 모듈과의 연계가 쉬움
- 타일즈, 사이트매시 같은 view 기술과의 연계가 쉬움
- 태그 라이브러리를 통해 message 출력, theme 적용 그리고 입력 폼을 보다 쉽게 구현 할 수 있음

1. DispatcherServlet
    - 클라이언트의 요청을 전달받아 해당 요청에 대한 컨트롤러를 선택, 클라이언트의 요청을 전달, 컨트롤러가 반환한 값을 View에 전달하여 알맞은 응답을 생성
2. HandlerMapping
    - 클라이언트가 요청한 URL을 처리할 컨트롤러를 지정
3. Controller
    - 클라이언트의 요청을 처리한 후 그 결과를 DispatcherServlet에 전달함
4. ModelAndView
    - 컨트롤러가 처리한 결과 및 뷰 선택에 필요한 정보를 저장
5. ViewResolver
    - 컨트롤러의 처리 결과를 전달할 뷰를 지정합니다.
6. View
    - 컨트롤러의 처리 결과 화면을 생성
    
