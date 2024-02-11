import HeaderContainer from "./container/header-container";
import FooterContainer from "./container/FooterContainer";
import "./globals.css";

export default function Home() {
  return (
    <body className="body">
      <>
        <HeaderContainer />
        <FooterContainer />
      </>
    </body>
  );
}
