import SwiftUI
import Shared

class ContentViewModel: ObservableObject {
    func stepButtonClicked() {
        objectWillChange.send()
    }
}

struct ContentView: View {
    @StateObject private var viewModel = ContentViewModel()
    private let counterManager = CounterManager()
    
    var body: some View {
        VStack {
            Group {
                Text("Count: ") +
                Text("\(counterManager.count)")
                    .foregroundColor(getColor(counterManager.color))
            }
            .font(.system(size: 24, weight: .bold))
            
            HStack {
                Button(action: {
                    viewModel.stepButtonClicked()
                    counterManager.decrement()
                }) {
                    Text("Decrement")
                        .padding()
                        .foregroundColor(Color.white)
                        .background(Color.blue)
                        .clipShape(Capsule())
                }
                
                Button(action: {
                    viewModel.stepButtonClicked()
                    counterManager.increment()
                }) {
                    Text("Increment")
                        .padding()
                        .foregroundColor(Color.white)
                        .background(Color.blue)
                        .clipShape(Capsule())
                }
            }
            .padding(.top)

            Divider()
                .padding(.vertical)
            
            Text("\(Greeting().greet())")
        }
    }
    
    func getColor(_ color: CounterTextColor) -> Color {
        switch color {
        case .black:
            return Color.black
        case .green:
            return Color.green
        case .red:
            return Color.red
        default:
            return Color.black
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
