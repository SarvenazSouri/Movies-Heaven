"use client";
import React, { Component, useState } from "react";
import HeaderComponent from "../component/header-component";
import LoginModal from "../component/LoginModal-component";
import Details from "../component/detail-modal-component";
import ListFilm from "../component/list-film-component";
 
class HeaderContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showLoginModal: false,
      showListFilm: true,
      isLoggedIn: false,
      show: false,
      movie: [],
      searchValue: "",
    };
  }
 
  handleLoginClick = () => {
    this.setState({ showLoginModal: true });
  };
 
  handleCloseModal = () => {
    this.setState({ showLoginModal: false });
  };
 
  handleListFilmClick = () => {
    this.setState({ showListFilm: true });
  };
 
  handleCloseListFilm = () => {
    this.setState({ showListFilm: false });
  };
 
  handleLoginSuccess = () => {
    this.setState({ showLoginModal: false, isLoggedIn: true });
  };
 
  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  };
 
  showModal = (movie) => {
    this.setState({ show: true, movie });
  };
 
  hideModal = () => {
    this.setState({ show: false });
  };

  handleSearchSubmit = (value) => {
    this.setState({ searchValue: value });
    this.setState({ showListFilm: true });
  };
 
  render() {
    return (
      <div>
        <HeaderComponent
          onLoginClick={this.handleLoginClick}
          isLoggedIn={this.state.isLoggedIn}
          onLoginSuccess={this.handleLoginSuccess}
          onLogout={this.handleLogout}
          onListFilmClick={this.handleListFilmClick}
          onSearchSubmit={this.handleSearchSubmit}
        />
 
        <LoginModal
          onClose={this.handleCloseModal}
          showLoginModal={this.state.showLoginModal}
          onLoginSuccess={this.handleLoginSuccess}
        />
 
        {this.state.showListFilm ? (
          <ListFilm showDetails={this.showModal} searchValue={this.state.searchValue}/>
        ) : null}
        <Details
          handleClose={this.hideModal}
          show={this.state.show}
          movie={this.state.movie}
        />
      </div>
    );
  }
}
 
export default HeaderContainer;