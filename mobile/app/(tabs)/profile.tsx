import React from "react";
import { Text, View } from "react-native";

export default function ProfileScreen() {
  return (
    <View className="flex-1 bg-gray-50 items-center justify-center p-6">
      <View className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100 items-center max-w-sm w-full">
        <Text className="text-2xl font-bold text-gray-800 mb-2">Profile Screen</Text>
        <Text className="text-gray-500 text-center">
          Manage your personal profile, settings, and preferences.
        </Text>
      </View>
    </View>
  );
}
