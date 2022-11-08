[1mdiff --git a/.idea/misc.xml b/.idea/misc.xml[m
[1mindex e46949d..f776b8a 100644[m
[1m--- a/.idea/misc.xml[m
[1m+++ b/.idea/misc.xml[m
[36m@@ -71,6 +71,12 @@[m
         <entry key="..\:/Users/Saeng/AndroidStudioProjects/ecommerceconcept/app/src/main/res/menu/bottom_navigation_menu.xml" value="0.3171875" />[m
         <entry key="..\:/Users/Saeng/AndroidStudioProjects/ecommerceconcept/app/src/main/res/xml/rating_empty.xml" value="0.3171875" />[m
         <entry key="..\:/Users/Saeng/AndroidStudioProjects/ecommerceconcept/app/src/main/res/xml/rating_fill.xml" value="0.3171875" />[m
[32m+[m[32m        <entry key="..\:/Users/Saeng/AndroidStudioProjects/tt_new/app/src/main/res/drawable/bg_bottom_navigation_bar.xml" value="0.32" />[m
[32m+[m[32m        <entry key="..\:/Users/Saeng/AndroidStudioProjects/tt_new/app/src/main/res/drawable/bg_capacity_option_disabled.xml" value="0.32" />[m
[32m+[m[32m        <entry key="..\:/Users/Saeng/AndroidStudioProjects/tt_new/app/src/main/res/drawable/bg_counter.xml" value="0.32" />[m
[32m+[m[32m        <entry key="..\:/Users/Saeng/AndroidStudioProjects/tt_new/app/src/main/res/drawable/ic_camera.xml" value="0.32" />[m
[32m+[m[32m        <entry key="..\:/Users/Saeng/AndroidStudioProjects/tt_new/app/src/main/res/drawable/ic_cart.xml" value="0.32" />[m
[32m+[m[32m        <entry key="..\:/Users/Saeng/AndroidStudioProjects/tt_new/app/src/main/res/drawable/ic_check.xml" value="0.236" />[m
         <entry key="..\:/Users/Saeng/AndroidStudioProjects/tt_new/cart/src/main/res/layout/fragment_cart.xml" value="0.3171875" />[m
       </map>[m
     </option>[m
[1mdiff --git a/app/src/main/res/layout/activity_main.xml b/app/src/main/res/layout/activity_main.xml[m
[1mindex 511baf9..659a08b 100644[m
[1m--- a/app/src/main/res/layout/activity_main.xml[m
[1m+++ b/app/src/main/res/layout/activity_main.xml[m
[36m@@ -13,7 +13,6 @@[m
         android:layout_weight="1" />[m
 [m
     <com.google.android.material.bottomnavigation.BottomNavigationView[m
[31m-        android:id="@+id/bottom_navigation_bar"[m
         android:layout_width="match_parent"[m
         android:layout_height="wrap_content"[m
         android:background="@drawable/bg_bottom_navigation_bar"[m
[1mdiff --git a/app/src/main/res/menu/bottom_navigation_menu.xml b/app/src/main/res/menu/bottom_navigation_menu.xml[m
[1mindex 4a576ed..1b6695f 100644[m
[1m--- a/app/src/main/res/menu/bottom_navigation_menu.xml[m
[1m+++ b/app/src/main/res/menu/bottom_navigation_menu.xml[m
[36m@@ -10,12 +10,10 @@[m
         android:icon="@drawable/ic_cart"[m
         android:title="@string/cart"/>[m
     <item[m
[31m-        android:id="@+id/favorites"[m
         android:enabled="true"[m
         android:icon="@drawable/ic_favorite"[m
         android:title="@string/favorites"/>[m
     <item[m
[31m-        android:id="@+id/profile"[m
         android:enabled="true"[m
         android:icon="@drawable/ic_profile"[m
         android:title="@string/profile"/>[m
[1mdiff --git a/app/src/main/res/values/arrays.xml b/app/src/main/res/values/arrays.xml[m
[1mindex fbee769..0d2c4cc 100644[m
[1m--- a/app/src/main/res/values/arrays.xml[m
[1m+++ b/app/src/main/res/values/arrays.xml[m
[36m@@ -1,26 +1,4 @@[m
 <?xml version="1.0" encoding="utf-8"?>[m
 <resources>[m
[31m-    <string-array name="brand_filter">[m
[31m-        <item>Samsung</item>[m
[31m-        <item>Xiaomi</item>[m
[31m-        <item>Motorola</item>[m
[31m-        <item>Apple</item>[m
[31m-        <item>Google</item>[m
[31m-        <item>Nokia</item>[m
[31m-    </string-array>[m
 [m
[31m-    <string-array name="price_filter">[m
[31m-        <item>$0 \- $100</item>[m
[31m-        <item>$100 \- $300</item>[m
[31m-        <item>$300 \- $500</item>[m
[31m-        <item>$500 \- $800</item>[m
[31m-        <item>$800 \- $1000</item>[m
[31m-        <item>$1000 \- $2000</item>[m
[31m-        <item>$2000 \- $5000</item>[m
[31m-        <item>$5000 \- $10000</item>[m
[31m-    </string-array>[m
[31m-[m
[31m-    <string-array name="size_filter">[m
[31m-        <item>4.5 to 5.5 inches</item>[m
[31m-    </string-array>[m
 </resources>[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/res/values/colors.xml b/app/src/main/res/values/colors.xml[m
[1mindex e8e872e..0613af0 100644[m
[1m--- a/app/src/main/res/values/colors.xml[m
[1m+++ b/app/src/main/res/values/colors.xml[m
[36m@@ -1,7 +1,5 @@[m
 <?xml version="1.0" encoding="utf-8"?>[m
 <resources>[m
[31m-    <color name="purple_200">#FFBB86FC</color>[m
[31m-    <color name="purple_500">#FF6200EE</color>[m
     <color name="purple_700">#FF3700B3</color>[m
     <color name="teal_200">#FF03DAC5</color>[m
     <color name="teal_700">#FF018786</color>[m
[36m@@ -10,10 +8,5 @@[m
     <color name="blue">#010035</color>[m
     <color name="blue_half_opacity">#80010035</color>[m
     <color name="orange">#FF6E4E</color>[m
[31m-    <color name="background">#F5F5F5</color>[m
[31m-    <color name="light_grey">#DCDCDC</color>[m
[31m-    <color name="grey">#CCCCCC</color>[m
     <color name="alt_grey">#B7B7B7</color>[m
[31m-    <color name="dark_grey">#B3B3C3</color>[m
[31m-    <color name="yellow">#FFB800</color>[m
 </resources>[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/res/values/dimens.xml b/app/src/main/res/values/dimens.xml[m
[1mindex 6dffe5d..0d2c4cc 100644[m
[1m--- a/app/src/main/res/values/dimens.xml[m
[1m+++ b/app/src/main/res/values/dimens.xml[m
[36m@@ -1,13 +1,4 @@[m
 <?xml version="1.0" encoding="utf-8"?>[m
 <resources>[m
[31m-    <dimen name="text_size_augmented">35sp</dimen>[m
[31m-    <dimen name="text_size_title">25sp</dimen>[m
[31m-    <dimen name="text_size_big">18sp</dimen>[m
[31m-    <dimen name="text_size_normal">16sp</dimen>[m
[31m-    <dimen name="text_size_small">12sp</dimen>[m
[31m-    <dimen name="text_size_diminished">10sp</dimen>[m
 [m
[31m-    <dimen name="view_page_margin">-29dp</dimen>[m
[31m-    <dimen name="view_page_offset">74dp</dimen>[m
[31m-    <dimen name="explorer_list_padding_horizontal">14dp</dimen>[m
 </resources>[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/res/values/ic_splash_icon_background.xml b/app/src/main/res/values/ic_splash_icon_background.xml[m
[1mindex e4e740c..a6b3dae 100644[m
[1m--- a/app/src/main/res/values/ic_splash_icon_background.xml[m
[1m+++ b/app/src/main/res/values/ic_splash_icon_background.xml[m
[36m@@ -1,4 +1,2 @@[m
 <?xml version="1.0" encoding="utf-8"?>[m
[31m-<resources>[m
[31m-    <color name="ic_splash_icon_background">#3DDC84</color>[m
[31m-</resources>[m
\ No newline at end of file[m
[32m+[m[32m<resources></resources>[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/res/values/strings.xml b/app/src/main/res/values/strings.xml[m
[1mindex 2a397bd..7a202c3 100644[m
[1m--- a/app/src/main/res/values/strings.xml[m
[1m+++ b/app/src/main/res/values/strings.xml[m
[36m@@ -1,34 +1,7 @@[m
 <resources>[m
     <string name="app_name">Ecommerce Concept</string>[m
[31m-    <string name="category_title">Select Category</string>[m
[31m-    <string name="categories_expand">view all</string>[m
[31m-    <string name="category_computer_title">Computer</string>[m
[31m-    <string name="search_hint">Search</string>[m
[31m-    <string name="hot_sales_title">Hot sales</string>[m
[31m-    <string name="buy">Buy now!</string>[m
[31m-    <string name="best_seller_title">Best Seller</string>[m
[31m-    <string name="expand_hot_sales">see more</string>[m
[31m-    <string name="price_format_string">$%1$s</string>[m
[31m-    <string name="filter_options_title">Filter options</string>[m
[31m-    <string name="no_data_exception">No data</string>[m
[31m-    <string name="brand_filter_title">Brand</string>[m
[31m-    <string name="price_filter_title">Price</string>[m
[31m-    <string name="size_filter_title">Size</string>[m
[31m-    <string name="product_details_title">Product Details</string>[m
[31m-    <string name="product_details_shop_tab_title">Shop</string>[m
[31m-    <string name="product_details_details_tab_title">Details</string>[m
[31m-    <string name="product_details_features_tab_title">Features</string>[m
[31m-    <string name="selector_title">Select color and capacity</string>[m
[31m-    <string name="capacity_format_string">%1$s GB</string>[m
     <string name="explorer">Explorer</string>[m
     <string name="cart">Cart</string>[m
     <string name="favorites">Favorites</string>[m
     <string name="profile">Profile</string>[m
[31m-    <string name="add_address_title">Add address</string>[m
[31m-    <string name="my_cart">My Cart</string>[m
[31m-    <string name="checkout">Checkout</string>[m
[31m-    <string name="delivery_title">Delivery</string>[m
[31m-    <string name="sum_title">Total</string>[m
[31m-    <string name="sum_value_format_string">$%1$s us</string>[m
[31m-    <string name="free_delivery_value">Free</string>[m
 </resources>[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/res/values/styles.xml b/app/src/main/res/values/styles.xml[m
[1mindex 5f094f5..0d2c4cc 100644[m
[1m--- a/app/src/main/res/values/styles.xml[m
[1m+++ b/app/src/main/res/values/styles.xml[m
[36m@@ -1,79 +1,4 @@[m
 <?xml version="1.0" encoding="utf-8"?>[m
 <resources>[m
[31m-    <style name="ProductDetailsTabTextStyle" parent="TextAppearance.Design.Tab">[m
[31m-        <item name="android:textColor">@color/orange</item>[m
[31m-    </style>[m
 [m
[31m-    <style name="ExplorerSectionTitleStyle">[m
[31m-        <item name="android:layout_width">wrap_content</item>[m
[31m-        <item name="android:layout_height">wrap_content</item>[m
[31m-        <item name="android:layout_marginHorizontal">17dp</item>[m
[31m-        <item name="android:layout_marginTop">18dp</item>[m
[31m-        <item name="android:fontFamily">@font/mark_pro_bold</item>[m
[31m-        <item name="android:textColor">@color/blue</item>[m
[31m-        <item name="android:textSize">@dimen/text_size_title</item>[m
[31m-        <item name="layout_constraintHorizontal_chainStyle">spread_inside</item>[m
[31m-    </style>[m
[31m-[m
[31m-    <style name="ExplorerSectionExpandButtonStyle">[m
[31m-        <item name="android:layout_width">wrap_content</item>[m
[31m-        <item name="android:layout_height">0dp</item>[m
[31m-        <item name="android:layout_marginHorizontal">33dp</item>[m
[31m-        <item name="android:textColor">@color/orange</item>[m
[31m-        <item name="android:textSize">@dimen/text_size_normal</item>[m
[31m-        <item name="android:fontFamily">@font/mark_pro_regular</item>[m
[31m-        <item name="android:gravity">center</item>[m
[31m-    </style>[m
[31m-[m
[31m-    <style name="FilterOptionTextInputLayoutStyle" parent = "@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.ExposedDropdownMenu">[m
[31m-        <item name="android:layout_width">0dp</item>[m
[31m-        <item name="android:layout_height">wrap_content</item>[m
[31m-        <item name="android:layout_marginRight">31dp</item>[m
[31m-        <item name="boxCornerRadiusBottomEnd">5dp</item>[m
[31m-        <item name="boxCornerRadiusBottomStart">5dp</item>[m
[31m-        <item name="boxCornerRadiusTopEnd">5dp</item>[m
[31m-        <item name="boxCornerRadiusTopStart">5dp</item>[m
[31m-        <item name="boxStrokeColor">@color/edit_text_box_border</item>[m
[31m-        <item name="boxStrokeWidth">1dp</item>[m
[31m-        <item name="boxStrokeWidthFocused">1dp</item>[m
[31m-        <item name="endIconDrawable">@drawable/ic_expand</item>[m
[31m-        <item name="endIconTint">@color/dark_grey</item>[m
[31m-    </style>[m
[31m-[m
[31m-    <style name="FilterOptionAutoCompleteTextViewStyle" parent = "@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox.ExposedDropdownMenu">[m
[31m-        <item name="android:layout_width">match_parent</item>[m
[31m-        <item name="android:layout_height">match_parent</item>[m
[31m-        <item name="android:background">@null</item>[m
[31m-        <item name="android:dropDownSelector">@drawable/filter_spinner_dropdown_bg</item>[m
[31m-        <item name="android:ellipsize">end</item>[m
[31m-        <item name="android:fontFamily">@font/mark_pro_regular</item>[m
[31m-        <item name="android:inputType">none</item>[m
[31m-        <item name="android:maxLines">1</item>[m
[31m-        <item name="android:paddingTop">10dp</item>[m
[31m-        <item name="android:paddingBottom">10dp</item>[m
[31m-        <item name="android:singleLine">true</item>[m
[31m-        <item name="android:textColor">@color/blue</item>[m
[31m-        <item name="android:textSize">@dimen/text_size_big</item>[m
[31m-    </style>[m
[31m-[m
[31m-    <style name="FilterTitleStyle">[m
[31m-        <item name="android:layout_width">wrap_content</item>[m
[31m-        <item name="android:layout_height">wrap_content</item>[m
[31m-        <item name="android:layout_marginHorizontal">46dp</item>[m
[31m-        <item name="android:fontFamily">@font/mark_pro_medium</item>[m
[31m-        <item name="android:textColor">@color/blue</item>[m
[31m-        <item name="android:textSize">@dimen/text_size_big</item>[m
[31m-        <item name="layout_constraintHorizontal_bias">0</item>[m
[31m-    </style>[m
[31m-[m
[31m-    <style name="IconButtonStyle">[m
[31m-        <item name="android:layout_width">52dp</item>[m
[31m-        <item name="android:layout_height">52dp</item>[m
[31m-        <item name="android:insetLeft">0dp</item>[m
[31m-        <item name="android:insetTop">0dp</item>[m
[31m-        <item name="android:insetRight">0dp</item>[m
[31m-        <item name="android:insetBottom">0dp</item>[m
[31m-        <item name="iconGravity">textStart</item>[m
[31m-        <item name="iconPadding">0dp</item>[m
[31m-    </style>[m
 </resources>[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/res/values/themes.xml b/app/src/main/res/values/themes.xml[m
[1mindex 051fc42..1659e09 100644[m
[1m--- a/app/src/main/res/values/themes.xml[m
[1m+++ b/app/src/main/res/values/themes.xml[m
[36m@@ -24,10 +24,6 @@[m
         <item name="bottomSheetDialogTheme">@style/AppBottomSheetDialogTheme</item>[m
     </style>[m
 [m
[31m-    <style name="Theme.MyApplication.AppBarOverlay" parent="ThemeOverlay.AppCompat.Dark.ActionBar" />[m
[31m-[m
[31m-    <style name="Theme.MyApplication.PopupOverlay" parent="ThemeOverlay.AppCompat.Light" />[m
[31m-[m
     <style name="Theme.App.Starting" parent="Theme.SplashScreen">[m
         <item name="windowSplashScreenBackground">@color/blue</item>[m
         <item name="windowSplashScreenAnimatedIcon">@drawable/ic_logo_foreground</item>[m
