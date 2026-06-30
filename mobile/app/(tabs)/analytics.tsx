import React from "react";
import { Text, View } from "react-native";

export default function AnalyticsScreen() {
  return (
    <View className="flex-1 bg-gray-50 items-center justify-center p-6">
      <View className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100 items-center max-w-sm w-full">
        <Text className="text-2xl font-bold text-gray-800 mb-2">Analytics Screen</Text>
        <Text className="text-gray-500 text-center">
          Monitor your health, habits, and progress charts.
        </Text>
      </View>
    </View>
  );
}
