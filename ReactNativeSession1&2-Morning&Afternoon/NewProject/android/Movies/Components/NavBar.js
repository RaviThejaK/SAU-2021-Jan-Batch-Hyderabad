/* eslint-disable prettier/prettier */
import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import styles from './Styles'


const NavBar = ({ title }) => {
    return (
        <View style={styles.NavBar} >
            <Text style={styles.Navtext}>{title}</Text>
        </View>
    );
};


// NavBar.defaultProps = {
//     title: '', // can keep based on requirement
// };

export default NavBar;
