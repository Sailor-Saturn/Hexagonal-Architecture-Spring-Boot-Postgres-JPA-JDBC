import React from "react";
import { FormattedMessage } from "react-intl";
import LocalePicker from "../LocalePicker";
import { Link } from "react-router-dom";

const NavBar = () => (
  <nav className="navbar navbar-expand-lg navbar-light bg-light">
    <a className="navbar-brand">
      <Link to="/" style={{ textDecoration: "none", color: "inherit" }}>
        Gorgeous Food
      </Link>
    </a>
    <button
      className="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarNavAltMarkup"
      aria-controls="navbarNavAltMarkup"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div className="navbar-nav">
        <Link to="/sandwiches" className="nav-item nav-link">
          <FormattedMessage id="navBar.sandwiches" />
        </Link>
      </div>
    </div>
    <LocalePicker />
  </nav>
);

export default NavBar;
