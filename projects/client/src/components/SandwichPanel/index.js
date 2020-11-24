import React from "react";
import styles from "./index.module.css";
import cx from "classnames";
import { FormattedMessage } from "react-intl";
import PropTypes from "prop-types";
import Image from "../Image";
import { Link } from "react-router-dom";

const SandwichPanel = props => {
  return (
    <div className={props.className}>
      <div className={cx("row", styles.imageContainer)}>
        <Link
          to={`sandwiches/${props.id}`}
          style={{ width: "100%", height: "100%" }}
        >
          <Image />
        </Link>
      </div>
      <div className={cx("row align-items-center", styles.informationRow)}>
        <div className="col-12 col-md-8">
          <Link to={`sandwiches/${props.id}`}>{props.name}</Link>
        </div>
        {null && (
          <div className="col-6 col-md-4">
            <input type="number" className={styles.quantityInput} />
          </div>
        )}
      </div>
      {null && (
        <div className="row justify-content-end">
          <button className="btn btn-success">
            <FormattedMessage id="sandwichPanel.addToCart" />
          </button>
        </div>
      )}
    </div>
  );
};

SandwichPanel.propTypes = {
  className: PropTypes.string,
  name: PropTypes.string.isRequired,
  id: PropTypes.number.isRequired,
};

SandwichPanel.defaultProps = {
  className: undefined,
};

export default SandwichPanel;
