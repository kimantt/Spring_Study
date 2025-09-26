// prdNoCheck5.js
// axios 사용 요청 post 방식
$(document).ready(function() {
	$('#prdNoCheckBtn').on('click', function() {
		event.preventDefault();
		
		let prdNo = $('#prdNo').val();
		
		if (prdNo == "") {
			alert("상품번호를 입력하세요.");
			return false;
		}
		else { // 서버 측에 상품번호 중복 확인 요청
			// 자바스크립트 라이브러리 axios.post(url, data{key:value}).then(function(response){처리코드})
			let data = {"prdNo":prdNo};
			axios.post("/mybatis/product/prdNoCheck5", data)
			.then(function(response) {
				if (response.data == "available") {
					alert("사용가능한 번호입니다.");
				}
				else {
					alert("사용 불가능한 번호입니다.");
				}
			})
			.catch(err => console.log(err));
		}
	}); // on 종료
}); // ready 종료
