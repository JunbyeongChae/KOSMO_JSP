import ReactDOM from 'react-dom/client';
import App from './App';
import { BrowserRouter } from 'react-router';
import { Provider } from 'react-redux';
import { legacy_createStore } from 'redux';
import rootReducer from './redux/rootReducer';
import AuthLogic from './service/authLogic';
import { app } from './service/firebase';
import { setAuth } from './redux/userAuth/action';

const root = ReactDOM.createRoot(document.getElementById('root'));
const authLogic = new AuthLogic(app);
let store = legacy_createStore(rootReducer);
store.dispatch(setAuth(authLogic.getUserAuth(), authLogic.getGoogleAuthProvider()));
console.log(store.getState()||'store is empty');

root.render(
  <>
  <BrowserRouter>
    <Provider store={store}>
      <App />
    </Provider>
  </BrowserRouter>
  </>
);