import React from "react";
import styles from "./index.module.css";
import cx from "classnames";
import PropTypes from "prop-types";
import { FormattedMessage } from "react-intl";

const Cart = props => {
  const renderCartItem = item => (
    <div className={styles.Item}>
      {item.quantity} x {item.name}
    </div>
  );

  const renderCartItems = items => items.map(renderCartItem);

  const renderOrderBtn = () => (
    <button className="btn btn-success">
      <FormattedMessage id="cart.order" />
    </button>
  );

  return (
    <div className={styles.container}>
      <span>Cart</span>
      <div className={cx("container", styles.Cart)}>
        <div className={cx("row", styles.itemRow)}>
          {renderCartItems(props.items)}
          <div className="container">
            <div
              className={cx("row justify-content-center", styles.orderBtnRow)}
            >
              <div className="col">{renderOrderBtn()}</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

Cart.propTypes = {
  items: PropTypes.array.isRequired,
};

export default Cart;
