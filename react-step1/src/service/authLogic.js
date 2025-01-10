import { getAuth, GoogleAuthProvider } from "firebase/auth";

class AuthLogic {
  //생성자함수
  constructor() {
    this.auth = getAuth();
    this.googleProvider = new GoogleAuthProvider();
    //this.githubProvider = new GithubAuthProvider();
  }
  //생성자함수에 초기화된 멤버변수를 외부에서 사용할 때 활용
  getUserAuth = () => {
    return this.auth;
  };
  //생성자함수에 초기화된 멤버변수를 외부에서 사용할 때 활용
  getGoogleAuthProvider = () => {
    return this.googleProvider;
  };
} //////////////////////////////////////////////end of AuthLogic

export default AuthLogic;

//3000번 리액트서버에서 구글서버측에 파라미터로 auth객체,벤더이름
export const loginGoogle = (auth, googleProvider) => {
  return new Promise((resolve, reject) => {
    auth
      .signInWithPopup(googleProvider)
      .then((res) => {
        const user = res.user;
        localStorage.setItem("uid", user.uid);
        localStorage.setItem("email", user.email);
        resolve(res);
      })
      .catch((err) => reject(err));
  });
}; //////////////////////////////////////////////end of loginGoogle

export const logout = (auth) => {
  return new Promise((resolve, reject) => {
    auth.signOut().catch((error) => {
      reject(alert(error));
    });
    localStorage.removeItem("uid");
    localStorage.removeItem("email");
    resolve();
  });
};

//로그인 풀릴 때 처리하기
export const onAuthChange = (auth) => {
  return new Promise((resolve, reject) => {
    auth.onAuthStateChanged((user) => {
      resolve(user);
    });
  });
};

//이메일/비번 로그인
//로그인은 모두 클라우드 서비스를 활용 하므로 필연적으로 지연과 비동기적 상황이 발생.
export const loginEmail = (auth, user) => { //user = {email: 'xxxx@xxxx.com', password: '123456'}
  console.log(user.email);
  console.log(user.password);
  return new Promise((resolve, reject) => {
    //구글api가 제공하는 함수 호출
    //@param1 - auth(리덕스), @param2 - 이메일, @param3 - 비번
    auth
      .signInWithEmailAndPassword(auth, user.email, user.password)
      .then((res) => {
        const user = res.user;
        localStorage.setItem("uid", user.uid);
        localStorage.setItem("email", user.email);
        resolve(res);
      }
    )
      .catch((err) => {
        const errorCode = err.code;
        const errorMessage = err.message;
        console.log(`error code:${errorCode}, error message:${errorMessage}`);
        reject(err)
      }
    );
  });
}