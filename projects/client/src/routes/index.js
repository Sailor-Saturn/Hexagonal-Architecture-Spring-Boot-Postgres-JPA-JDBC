import React from "react";
import App from "../containers/App";
import Home from "../containers/Home";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

import SandwichesList from "../containers/SandwichesList";
import Sandwich from "../containers/Sandwich";

const AppRouter = () => {
  return (
    <Router>
      <Route path="/" component={App} />
      <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/sandwiches" component={SandwichesList} />
        <Route exact path="/sandwiches/:id" component={Sandwich} />
      </Switch>
    </Router>
  );
};

export default AppRouter;
