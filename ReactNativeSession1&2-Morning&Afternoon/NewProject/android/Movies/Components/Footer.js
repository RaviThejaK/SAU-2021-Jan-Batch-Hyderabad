/* eslint-disable no-unused-vars*//* eslint-disable prettier/prettier */
import React, { useState, useEffect } from 'react';
//import { View, Text, StyleSheet, Image, FlatList, ActivityIndicator, SafeAreaView, ScrollView, Button } from 'react-native';
import SlideDetails from './SlideDetails';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Slide from './Slide';
import Slide2 from './Slide2';
import Slide3 from './Slide3';
import styles from './Styles';
//import { MaterialCommunityIcons } from '@expo/vector-icons';


const Footer = () => {


    const Foot = createBottomTabNavigator();

    return (
        <NavigationContainer style={styles.navc}>
            <Foot.Navigator style={styles.tab}>

                <Foot.Screen name="Popular" style={styles.tab1} component={Slide} />
                <Foot.Screen name="Top-Rated" style={styles.tab2} component={Slide2} />
                <Foot.Screen name="Upcomming" style={styles.tab3} component={Slide3} />
                <Foot.Screen name="SlideDetails" component={SlideDetails} style={styles.slidet} />
            </Foot.Navigator>


        </NavigationContainer>
    );
};




export default Footer;
