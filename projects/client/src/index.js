import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import reportWebVitals from "./reportWebVitals";
import IntlWrapper from "./components/IntlWrapper";
import Routes from "./routes";

ReactDOM.render(
  <IntlWrapper>
    <React.StrictMode>
      <Routes />
    </React.StrictMode>
  </IntlWrapper>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
