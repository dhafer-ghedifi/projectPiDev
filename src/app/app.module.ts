import { BrowserModule } from '@angular/platform-browser';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PreloaderComponent } from './components/common/preloader/preloader.component';
import { HomeOneComponent } from './components/pages/home-one/home-one.component';
import { HomeTwoComponent } from './components/pages/home-two/home-two.component';
import { HomeThreeComponent } from './components/pages/home-three/home-three.component';
import { NavbarStyleOneComponent } from './components/common/navbar-style-one/navbar-style-one.component';
import { NavbarStyleTwoComponent } from './components/common/navbar-style-two/navbar-style-two.component';
import { FooterStyleOneComponent } from './components/common/footer-style-one/footer-style-one.component';
import { FooterStyleTwoComponent } from './components/common/footer-style-two/footer-style-two.component';
import { AboutComponent } from './components/pages/about/about.component';
import { TeamComponent } from './components/pages/team/team.component';
import { PricingComponent } from './components/pages/pricing/pricing.component';
import { CategoryComponent } from './components/pages/category/category.component';
import { FaqComponent } from './components/pages/faq/faq.component';
import { TestimonialsComponent } from './components/pages/testimonials/testimonials.component';
import { ErrorComponent } from './components/pages/error/error.component';
import { LoginRegisterComponent } from './components/pages/login-register/login-register.component';
import { TermsConditionComponent } from './components/pages/terms-condition/terms-condition.component';
import { PrivacyPolicyComponent } from './components/pages/privacy-policy/privacy-policy.component';
import { ComingSoonComponent } from './components/pages/coming-soon/coming-soon.component';
import { ShopComponent } from './components/pages/shop/shop.component';
import { CartComponent } from './components/pages/cart/cart.component';
import { CheckoutComponent }  from'./components/pages/checkout/checkout.component';
import { ContactComponent } from './components/pages/contact/contact.component';
import { ChatroomComponent } from './components/pages/chatroom/chatroom.component';
import { HttpClientModule } from '@angular/common/http';
import { AddChatroomComponent } from './components/pages/add-chatroom/add-chatroom.component';
import { LoginchatComponent } from './components/pages/loginchat/loginchat.component';
import { ChatComponent } from './components/chat/chat.component';
import { ProductsDetailsComponent } from './components/pages/products-details/products-details.component';
import { ListingComponent } from './components/pages/listing/listing.component';
import { ListingDetailsComponent } from './components/pages/listing-details/listing-details.component';
import { BlogComponent } from './components/pages/blog/blog.component';
import { AdduserchatroomComponent } from './components/pages/adduserchatroom/adduserchatroom.component';
import { BlogDetailsComponent } from './components/pages/blog-details/blog-details.component';
import { ChartComponent } from './components/chart/chart.component';
import { ChartsModule } from 'ng2-charts';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ToastrModule } from 'ngx-toastr';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    
    AppComponent,
    PreloaderComponent,
    HomeOneComponent,
    HomeTwoComponent,
    HomeThreeComponent,
    NavbarStyleOneComponent,
    NavbarStyleTwoComponent,
    FooterStyleOneComponent,
    FooterStyleTwoComponent,
    AboutComponent,
    TeamComponent,
    PricingComponent,
    CategoryComponent,
    FaqComponent,
    TestimonialsComponent,
    ErrorComponent,
    LoginRegisterComponent,
    TermsConditionComponent,
    PrivacyPolicyComponent,
    ComingSoonComponent,
    ShopComponent,
    CartComponent,
    CheckoutComponent,
    ProductsDetailsComponent,
    ListingComponent,
    ListingDetailsComponent,
    BlogComponent,
    ContactComponent,
    ChatroomComponent,
    AddChatroomComponent,
    LoginchatComponent,
    ChatComponent,
    AdduserchatroomComponent,
    BlogDetailsComponent,
    ChartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    
    BrowserAnimationsModule,
  ChartsModule,
  ToastrModule.forRoot(),
  
  NgbModule,
  RouterModule,
  FormsModule
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA   ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
