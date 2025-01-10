import { combineReducers } from "redux";
import userAuth from "./userAuth/reducer";

const rootReducer = combineReducers({
  userAuth
})

export default rootReducer